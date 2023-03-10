package me.arsnotfound.roomexample.ui.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import me.arsnotfound.roomexample.data.Film;
import me.arsnotfound.roomexample.data.FilmDao;

public class MainActivityViewModel extends ViewModel {
    LiveData<List<Film>> filmsLiveData;

    public LiveData<List<Film>> getFilmsLiveData() {
        return filmsLiveData;
    }

    public MainActivityViewModel(FilmDao filmDao) {
        this.filmsLiveData = filmDao.getAllFilms();
    }

    public static class Factory implements ViewModelProvider.Factory {
        FilmDao filmDao;

        public Factory(FilmDao filmDao) {
            this.filmDao = filmDao;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MainActivityViewModel(filmDao);
        }
    }

}
