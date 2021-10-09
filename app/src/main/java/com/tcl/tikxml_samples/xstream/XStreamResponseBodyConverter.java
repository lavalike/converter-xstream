package com.tcl.tikxml_samples.xstream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.thoughtworks.xstream.XStream;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * XStreamResponseBodyConverter
 * Created by wangzhen on 2021/10/9
 */
public class XStreamResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final XStream xstream;
    private final Class<T> cls;

    public XStreamResponseBodyConverter(Class<T> cls, XStream xstream) {
        this.cls = cls;
        this.xstream = xstream;
    }

    @Nullable
    @Override
    public T convert(@NonNull ResponseBody value) throws IOException {
        Object o = xstream.fromXML(value.byteStream());
        return (T) o;
    }
}
