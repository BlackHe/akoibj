package com.peony.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {
    public static void main(String[] args) {
        SoftReference<Class<SoftReferenceDemo>> classSoftReference = new SoftReference<>(SoftReferenceDemo.class);
        Class<SoftReferenceDemo> softReferenceDemoClass = classSoftReference.get();
    }
}
