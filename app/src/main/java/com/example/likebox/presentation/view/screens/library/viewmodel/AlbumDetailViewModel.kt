package com.example.likebox.presentation.view.screens.library.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.likebox.di.Mock
import com.example.likebox.domain.model.library.Album
import com.example.likebox.domain.model.library.MusicContent
import com.example.likebox.domain.model.library.Track
import com.example.likebox.domain.repository.MusicRepository
import com.example.likebox.presentation.view.screens.library.state.DetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * 앨범 상세 화면의 ViewModel
 */
@HiltViewModel
class AlbumDetailViewModel @Inject constructor(
    @Mock private val musicRepository: MusicRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AlbumDetailState())
    val uiState: StateFlow<AlbumDetailState> = _uiState.asStateFlow()

    fun loadAlbum(albumId: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                // 앨범 정보 로드
                musicRepository.getAlbumById(albumId).fold(
                    onSuccess = { album ->
                        _uiState.update {
                            it.copy(
                                album = album,
                                tracks = album.tracks,
                                isLoading = false,
                                error = null
                            )
                        }
                    },
                    onFailure = { throwable ->
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                error = throwable.message
                            )
                        }
                    }
                )
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message
                    )
                }
            }
        }
    }

    fun toggleLiked(content: MusicContent) {
        viewModelScope.launch {
            try {
                musicRepository.addToLiked(content).fold(
                    onSuccess = {
                        // 좋아요 상태 업데이트 성공
                    },
                    onFailure = { throwable ->
                        _uiState.update {
                            it.copy(error = throwable.message)
                        }
                    }
                )
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(error = e.message)
                }
            }
        }
    }
}

data class AlbumDetailState(
    val album: Album? = null,
    val tracks : List<Track> = emptyList(),
    override val isLoading: Boolean = false,
    override val error: String? = null
) : DetailUiState