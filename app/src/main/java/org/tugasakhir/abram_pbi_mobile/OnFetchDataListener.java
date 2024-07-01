package org.tugasakhir.abram_pbi_mobile;

import org.tugasakhir.abram_pbi_mobile.ui.models.NewHeadLines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {
    void onFecthData(List<NewHeadLines> list, String message);
    void onError(String message);
}
