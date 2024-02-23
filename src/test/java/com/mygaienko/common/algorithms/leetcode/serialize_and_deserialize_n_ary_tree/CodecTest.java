package com.mygaienko.common.algorithms.leetcode.serialize_and_deserialize_n_ary_tree;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CodecTest {

    Codec codec = new Codec();

    @Test
    public void serialize() {
        var actual = codec.serialize(new Node(1,
                List.of(
                        new Node(3, List.of(new Node(5), new Node(6))),
                        new Node(2),
                        new Node(4)
                )
        ));
        assertThat(actual).isEqualTo("1,null,3,2,4,null,5,6");
    }

    @Test
    public void deserialize() {
        var actual = codec.deserialize("1,null,3,2,4,null,5,6");
        assertThat(actual).usingRecursiveComparison().isEqualTo(new Node(1,
                List.of(
                        new Node(3, List.of(new Node(5, List.of()), new Node(6, List.of()))),
                        new Node(2, List.of()),
                        new Node(4, List.of())
                )
        ));
    }

    @Test
    public void serialize1() {
        var actual = codec.serialize(new Node(1,
                List.of(
                        new Node(2, List.of()),
                        new Node(3, List.of(
                                new Node(6, List.of()),
                                new Node(7, List.of(new Node(11, List.of(new Node(14, List.of()))))))
                        ),
                        new Node(4, List.of(new Node(8, List.of(new Node(12, List.of()))))),
                        new Node(5, List.of(
                                new Node(9, List.of(new Node(13, List.of()))),
                                new Node(10, List.of()))
                        )
                )));
        assertThat(actual).isEqualTo("1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14");
    }

    @Test
    public void deserialize1() {
        var actual = codec.deserialize("1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14");
        assertThat(actual).usingRecursiveComparison().isEqualTo(new Node(1,
                List.of(
                        new Node(2, List.of()),
                        new Node(3, List.of(
                                new Node(6, List.of()),
                                new Node(7, List.of(new Node(11, List.of(new Node(14, List.of()))))))
                        ),
                        new Node(4, List.of(new Node(8, List.of(new Node(12, List.of()))))),
                        new Node(5, List.of(
                                new Node(9, List.of(new Node(13, List.of()))),
                                new Node(10, List.of()))
                        )
                )));
    }
}