// Largely borrowed from Jake Wharton's Kotterknife (https://github.com/JakeWharton/kotterknife)
// and paweljaneczek's PR for resetting cached views (https://github.com/JakeWharton/kotterknife/pull/37)

import android.app.Activity
import android.app.Dialog
import android.support.v4.app.DialogFragment
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bluelinelabs.conductor.Controller
import java.util.*
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

object ViewFinder {
    fun setup(target: Any, view: View) {
        LiveBindings.register(target, view)
    }

    fun tearDown(target: Any) {
        LiveBindings.reset(target)
    }
}

private val View.viewFinder: View.(Int) -> View?
    get() = { findViewById(it) }
private val Activity.viewFinder: Activity.(Int) -> View?
    get() = { findViewById(it) }
private val Dialog.viewFinder: Dialog.(Int) -> View?
    get() = { findViewById(it) }
private val DialogFragment.viewFinder: DialogFragment.(Int) -> View?
    get() = { dialog.findViewById(it) }
private val RecyclerView.ViewHolder.viewFinder: RecyclerView.ViewHolder.(Int) -> View?
    get() = { itemView.findViewById(it) }

public fun <V : View> Controller.findView(id: Int)
        : ReadOnlyProperty<Controller, V> = required(id, viewFinder)

public fun <V : View> Controller.findOptionalView(id: Int)
        : ReadOnlyProperty<Controller, V?> = optional(id, viewFinder)

public fun <V : View> Controller.findViews(vararg ids: Int)
        : ReadOnlyProperty<Controller, List<V>> = required(ids, viewFinder)

public fun <V : View> Controller.findOptionalViews(vararg ids: Int)
        : ReadOnlyProperty<Controller, List<V>> = optional(ids, viewFinder)

private val Controller.viewFinder: Controller.(Int) -> View?
    get() = { LiveBindings.targetView(this)?.findViewById(it) }

private fun viewNotFound(id: Int, desc: KProperty<*>): Nothing =
        throw IllegalStateException("View ID $id for '${desc.name}' not found.")

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> required(id: Int, finder: T.(Int) -> View?)
        = Lazy { t: T, desc -> t.finder(id) as V? ?: viewNotFound(id, desc) }

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> optional(id: Int, finder: T.(Int) -> View?)
        = Lazy { t: T, desc -> t.finder(id) as V? }

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> required(ids: IntArray, finder: T.(Int) -> View?)
        = Lazy { t: T, desc -> ids.map { t.finder(it) as V? ?: viewNotFound(it, desc) } }

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> optional(ids: IntArray, finder: T.(Int) -> View?)
        = Lazy { t: T, desc -> ids.map { t.finder(it) as V? }.filterNotNull() }

// Like Kotlin's lazy delegate but the initializer gets the target and metadata passed to it
private class Lazy<T, V>(private val initializer: (T, KProperty<*>) -> V) : ReadOnlyProperty<T, V> {
    private object EMPTY

    private var value: Any? = EMPTY

    override fun getValue(thisRef: T, property: KProperty<*>): V {
        LiveBindings.register(thisRef, this)
        if (value == EMPTY) {
            value = initializer(thisRef, property)
        }
        @Suppress("UNCHECKED_CAST")
        return value as V
    }

    fun reset() {
        value = EMPTY
    }
}

private object LiveBindings {
    private val viewMap = WeakHashMap<Any, View>()
    private val bindingMap = WeakHashMap<Any, MutableCollection<Lazy<*, *>>>()

    fun <T> targetView(target: T): View? {
        return viewMap[target]
    }

    fun <T> register(target: T, view: View) {
        viewMap.put(target, view)
    }

    fun <T> register(target: T, lazy: Lazy<T, *>) {
        bindingMap.getOrPut(target, { Collections.newSetFromMap(WeakHashMap()) }).add(lazy)
    }

    fun <T> reset(target: T) {
        viewMap.remove(target)
        bindingMap[target]?.forEach { it.reset() }
    }
}
