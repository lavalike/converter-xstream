package com.tcl.tikxml_samples.xstream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * XStreamResponseBodyConverter
 * Created by wangzhen on 2021/10/9
 */
public class XStreamResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    @Nullable
    @Override
    public T convert(@NonNull ResponseBody value) throws IOException {
        return null;
    }
}
