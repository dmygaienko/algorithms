package com.mygaienko.common.algorithms.leetcode.design_search_autocomplete_system;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AutocompleteSystemTest {

    @Test
    public void test() {
        var system = new AutocompleteSystem(
                new String[]{"i love you", "island", "iroman", "i love leetcode"},
                new int[]{5, 3, 2, 2}
        );

        assertThat(system.input('i')).containsExactly("i love you", "island", "i love leetcode");
        assertThat(system.input(' ')).containsExactly("i love you", "i love leetcode");
        assertThat(system.input('a')).isEmpty();
        assertThat(system.input('#')).isEmpty();
    }

    /**
     * ["AutocompleteSystem",
     * ["i love you","island","iroman","i love leetcode"],[5,3,2,2]
     * null
     * <p>
     * input
     * ["i"]
     * "i love you","island","i love leetcode"
     * <p>
     * "input"
     * [" "]
     * ["i love you","i love leetcode"]
     * <p>
     * "input"
     * ["a"]
     * []
     * <p>
     * "input"
     * ["#"]
     * []
     * <p>
     * "input"
     * ["i"]
     * ["i love you","island","i love leetcode"]
     * <p>
     * <p>
     * "input"
     * [" "]
     * ["i love you","i love leetcode","i a"]
     * <p>
     * "input"
     * ["a"]
     * ["i a"]
     * <p>
     * "input"
     * ["#"]
     * []
     * <p>
     * "input"
     * ["i"]
     * ["i love you","island","i a"]
     * <p>
     * "input"
     * ,[" "]
     * ["i love you","i a","i love leetcode"]
     * <p>
     * ,,,,,,,,,,"input","input"]
     * [[[,,,,,,,,,,["a"],["#"]]
     * [,[,,,,,,,,,,["i a"],[]]
     */
    @Test
    public void test2() {
        var system = new AutocompleteSystem(
                new String[]{"i love you", "island", "iroman", "i love leetcode"},
                new int[]{5, 3, 2, 2}
        );

        assertThat(system.input('i')).containsExactly("i love you", "island", "i love leetcode");
        assertThat(system.input(' ')).containsExactly("i love you", "i love leetcode");
        assertThat(system.input('a')).isEmpty();
        assertThat(system.input('#')).isEmpty();

        assertThat(system.input('i')).containsExactly("i love you", "island", "i love leetcode");
        assertThat(system.input(' ')).containsExactly("i love you", "i love leetcode", "i a");
        assertThat(system.input('a')).containsExactly("i a");
        assertThat(system.input('#')).isEmpty();

        assertThat(system.input('i')).containsExactly("i love you", "island", "i a");
        assertThat(system.input(' ')).containsExactly("i love you", "i a", "i love leetcode");
        assertThat(system.input('a')).containsExactly("i a");
        assertThat(system.input('#')).isEmpty();
    }
}