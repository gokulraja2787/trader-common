package org.gokapp.trader.common.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class KVPair<K, V> implements Serializable{
    
    private static final long serialVersionUID = -1L;

    @Getter
    @Setter
    private K key;

    @Getter
    @Setter
    private V value;
}
