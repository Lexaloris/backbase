package com.lexaloris.backbase.mainlist.utils;

import java.util.ArrayList;

class BinarySearchRightMore {

    int findIndex(ArrayList<String> array, int left, int right, String prefix, int size) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            boolean doesStringStartWithPrefix = doesStringStartWithPrefix(array.get(mid), prefix);
            if ((mid == size - 1 || isStringMoreThanPrefix(array.get(mid + 1), prefix)) && doesStringStartWithPrefix) {
                return mid;
            } else if (isStringMoreThanPrefix(array.get(mid), prefix)) {
                return findIndex(array, left, (mid - 1), prefix, size);
            } else {
                return findIndex(array, (mid + 1), right, prefix, size);
            }
        }
        return -1;
    }

    private boolean isStringMoreThanPrefix(String string, String prefix) {
        boolean isStringMoreThanPrefix = prefix.compareToIgnoreCase(string) < 0;
        return isStringMoreThanPrefix && !doesStringStartWithPrefix(string, prefix);
    }

    private boolean doesStringStartWithPrefix(String string, String prefix) {
        return string.startsWith(prefix);
    }
}
