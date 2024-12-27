package com.example.sdaassign32022;
/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/**
 * {@link TShirtDesignAdapter} represents a single Design art for a t-shirt.
 * Each object has 3 properties: name, size, and image resource ID.
 * This is a basic arrayAdapter
 */
public class TShirtDesignAdapter {

    // Version of the t-shirt design
    private String mStyleName;

    // Size of the t-shirt
    private String mSizes;

    // Drawable resource ID
    private int mImageResourceId;

    /*
     * Create a new FlavorAdapter object.
     * @param vName is the name of the design art (e.g. Skull)
     * @param vSize is the tshirt sizes available
     * @param image is drawable reference ID that corresponds to the design image on the tshirt
     *
     * */
    public TShirtDesignAdapter(String sName, String sizes, int imageResourceId)
    {
        mStyleName = sName;
        mSizes = sizes;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the T-Shirt version
     */
    public String getStyleName() {
        return mStyleName;
    }

    /**
     * Get the T-shirt available sizes
     */
    public String getAvailableSize() {
        return mSizes;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

}