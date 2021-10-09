package com.tcl.tikxml_samples.xstream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * XStreamConverterFactory
 * Created by wangzhen on 2021/10/9
 */
public class XStreamConverterFactory extends Converter.Factory {
    XStream xstream = new XStream(new StaxDriver());

    public static XStreamConverterFactory create() {
        return new XStreamConverterFactory();
    }

    @Nullable
    @Override
    public Converter<?, RequestBody> requestBodyConverter(@NonNull Type type, @NonNull Annotation[] parameterAnnotations, @NonNull Annotation[] methodAnnotations, @NonNull Retrofit retrofit) {
        if (!(type instanceof Class)) {
            return null;
        }
        return new XStreamRequestBodyConverter<>(xstream);
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(@NonNull Type type, @NonNull Annotation[] annotations, @NonNull Retrofit retrofit) {
        if (!(type instanceof Class)) {
            return null;
        }
        Class<?> cls = (Class<?>) type;
        return new XStreamResponseBodyConverter<>(cls, xstream);
    }
}
