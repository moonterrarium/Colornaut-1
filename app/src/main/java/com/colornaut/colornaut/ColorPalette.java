package com.colornaut.colornaut;

import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by vdesouza on 12/5/16.
 */

public class ColorPalette {

    private static final String TAG = "ColorPalette";

    // Swatches that make up a color palette
    // A Swatch is one type of color that appears the most
    // Swatches also carry various information about the color picked
    // https://developer.android.com/reference/android/support/v7/graphics/Palette.Swatch.html

    private Palette mPalette;
    private Bitmap image;
    private List<Palette.Swatch> paletteSwatches;
    private ArrayList<Integer> rgbValues = new ArrayList<Integer>();
    private ArrayList<String> hexValues = new ArrayList<String>();
    private String paletteName;
    private String location;


    public ColorPalette(Bitmap image) {
        this.image = image;
        mPalette = Palette.from(image).generate();
        this.paletteSwatches = mPalette.getSwatches();
        for (int i = 0; i <= paletteSwatches.size() - 1; i++) {
            this.rgbValues.add(i, paletteSwatches.get(i).getRgb());
            Log.i(TAG,i + " : " + rgbValues.get(i).toString());
        }
    }

    public List<Palette.Swatch> getPaletteSwatches() { return paletteSwatches; }
    public ArrayList<Integer> getSwatchesRgb() {
        ArrayList<Integer> list = new ArrayList<>();
        for (Palette.Swatch ps : paletteSwatches) {
            list.add(ps.getRgb());
        }
        return list;
    }
    public ArrayList<Integer> getRgbValues() { return rgbValues; }
    public Integer getRgbValue(int position) { return rgbValues.get(position); }
    public ArrayList<String> getHexValuess() { return hexValues; }
    public String getHexValue(int position) { return hexValues.get(position); }
    public String getPaletteName() { return paletteName; }
    public String getLocation() { return location; }
    public Bitmap getImage() { return image; }





}
