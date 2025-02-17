package ski.chrzanow.transformstring

import kotlin.test.Test
import kotlin.test.assertEquals

class Tests {

    @Test
    fun prepare() {
        assertEquals("hello world", "hello_world".prepare(" "))
        assertEquals("hello World", "helloWorld".prepare(" "))
        assertEquals("HELLO WORLD", "HELLO_WORLD".prepare(" "))
        assertEquals("hello world", "hello-world".prepare(" "))
        assertEquals("Hello world", "Hello@world".prepare(" "))

        assertEquals("Hello123world", "Hello123world".prepare(" "))

        assertEquals("leading separator1", "_leading_separator1".prepare(" "))
        assertEquals("leading_separator2", "_leading_separator2".prepare("_"))
        assertEquals("leading separator3", "  __leading_separator3".prepare(" "))
        assertEquals("leading_separator4", "_leading_separator4".prepare("_"))
        assertEquals("leading@separator5", "  __leading_separator5".prepare("@"))

        assertEquals("trailing@separator7", "  trailing_separator7_".prepare("@"))
        assertEquals("trailing@separator6", "  trailing_separator6@".prepare("@"))
        assertEquals("trailing@separator8", "  trailing_separator8@@__@".prepare("@"))

        assertEquals("leadingtrailing@separator8", "__@leadingtrailing_separator8@@__@".prepare("@"))
        assertEquals("leadingtrailing_separator8", "__@leadingtrailing_separator8@@__@".prepare("_"))
        assertEquals("leadingtrailing separator8", "__@leadingtrailing_separator8@@__@".prepare(" "))
    }
    @Test
    fun lowerCase() {
        assertEquals("foobar", "foo bar".transformstring())
        assertEquals("foobar", "foo-bar".transformstring())
        assertEquals("foobar", "foo_bar".transformstring())
        assertEquals("foobar", "FOO_BAR".transformstring())
        assertEquals("foobar", "FooBar".transformstring())
    }

    @Test
    fun upperCase() {
        assertEquals("FOOBAR", "foo bar".TRANSFORMSTRING())
        assertEquals("FOOBAR", "foo-bar".TRANSFORMSTRING())
        assertEquals("FOOBAR", "foo_bar".TRANSFORMSTRING())
        assertEquals("FOOBAR", "FOO_BAR".TRANSFORMSTRING())
        assertEquals("FOOBAR", "FooBar".TRANSFORMSTRING())
    }

    @Test
    fun camelCase() {
        assertEquals("fooBar", "foo bar".transformString())
        assertEquals("fooBar", "foo-bar".transformString())
        assertEquals("fooBar", "foo_bar".transformString())
        assertEquals("fooBar", "FOO_BAR".transformString())
        assertEquals("fooBar", "FooBar".transformString())
    }

    @Test
    fun pascalCase() {
        assertEquals("FooBar", "foo bar".TransformString())
        assertEquals("FooBar", "foo-bar".TransformString())
        assertEquals("FooBar", "foo_bar".TransformString())
        assertEquals("FooBar", "FOO_BAR".TransformString())
        assertEquals("FooBar", "FooBar".TransformString())
    }

    @Test
    fun lowerSnakeCase() {
        assertEquals("foo_bar", "foo bar".transform_string())
        assertEquals("foo_bar", "foo-bar".transform_string())
        assertEquals("foo_bar", "foo_bar".transform_string())
        assertEquals("foo_bar", "FOO_BAR".transform_string())
        assertEquals("foo_bar", "FooBar".transform_string())
    }

    @Test
    fun upperSnakeCase() {
        assertEquals("FOO_BAR", "foo bar".TRANSFORM_STRING())
        assertEquals("FOO_BAR", "foo-bar".TRANSFORM_STRING())
        assertEquals("FOO_BAR", "foo_bar".TRANSFORM_STRING())
        assertEquals("FOO_BAR", "FOO_BAR".TRANSFORM_STRING())
        assertEquals("FOO_BAR", "FooBar".TRANSFORM_STRING())
    }

    @Test
    fun lowerKebabCase() {
        assertEquals("foo-bar", "foo bar".`transform-string`())
        assertEquals("foo-bar", "foo-bar".`transform-string`())
        assertEquals("foo-bar", "foo_bar".`transform-string`())
        assertEquals("foo-bar", "FOO_BAR".`transform-string`())
        assertEquals("foo-bar", "FooBar".`transform-string`())
    }

    @Test
    fun upperKebabCase() {
        assertEquals("FOO-BAR", "foo bar".`TRANSFORM-STRING`())
        assertEquals("FOO-BAR", "foo-bar".`TRANSFORM-STRING`())
        assertEquals("FOO-BAR", "foo_bar".`TRANSFORM-STRING`())
        assertEquals("FOO-BAR", "FOO_BAR".`TRANSFORM-STRING`())
        assertEquals("FOO-BAR", "FooBar".`TRANSFORM-STRING`())
    }

    @Test
    fun alternativeCase() {
        assertEquals("fOo BaR", "foo bar".tRaNsFoRmStRiNg())
        assertEquals("fOo-BaR", "foo-bar".tRaNsFoRmStRiNg())
        assertEquals("fOo_BaR", "foo_bar".tRaNsFoRmStRiNg())
        assertEquals("fOo_BaR", "FOO_BAR".tRaNsFoRmStRiNg())
        assertEquals("fOoBaR", "FooBar".tRaNsFoRmStRiNg())
        assertEquals("1fOo-BaR", "1foo-bar".tRaNsFoRmStRiNg())
        assertEquals("fOo $ BaR", "foo $ bar".tRaNsFoRmStRiNg())
    }
}
