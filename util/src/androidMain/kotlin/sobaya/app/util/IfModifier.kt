package sobaya.app.util

import androidx.compose.ui.Modifier

inline fun Modifier.ifTrue(value: Boolean, builder: Modifier.() -> Modifier): Modifier {
    return then(if (value) builder() else Modifier)
}