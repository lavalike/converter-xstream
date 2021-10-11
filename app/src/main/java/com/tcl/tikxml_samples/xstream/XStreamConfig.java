package com.tcl.tikxml_samples.xstream;

import androidx.annotation.NonNull;

import com.thoughtworks.xstream.XStream;

/**
 * XStreamConfig
 * Created by wangzhen on 2021/10/11
 */
public final class XStreamConfig {

    private static XStreamConfig sInstance;
    private final XStream xstream;

    private XStreamConfig() {
        xstream = new XStream();
        xstream.autodetectAnnotations(true);
    }

    public static XStreamConfig getInstance() {
        if (sInstance == null)
            sInstance = new XStreamConfig();
        return sInstance;
    }

    public XStreamConfig registerTypes(Class<?>... types) {
        xstream.allowTypes(types);
        xstream.processAnnotations(types);
        return this;
    }

    @NonNull
    public XStream xstream() {
        return xstream;
    }
}
