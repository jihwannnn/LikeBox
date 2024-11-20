package com.example.likebox.data.repository

import com.example.likebox.data.firebase.FirebaseService
import com.example.likebox.domain.model.library.Track
import com.example.likebox.domain.model.library.Playlist
import com.example.likebox.domain.model.library.Album
import com.example.likebox.domain.model.library.Artist
import com.example.likebox.domain.model.library.ContentType
import com.example.likebox.domain.model.library.MusicContent
import com.example.likebox.domain.model.library.MusicPlatform
import com.example.likebox.domain.repository.MusicRepository

import com.google.firebase.Firebase
import com.google.firebase.functions.functions
import javax.inject.Inject


class MusicRepositoryImpl @Inject constructor(
    private val firebaseService: FirebaseService
) : MusicRepository {
    override suspend fun getLikedContent(
        platform: MusicPlatform,
        contentType: ContentType
    ): Result<List<MusicContent>> {
        TODO("Not yet implemented")
    }

    override suspend fun addToLiked(content: MusicContent): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromLiked(content: MusicContent): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun syncContent(
        platform: MusicPlatform,
        contentType: ContentType
    ): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun getTracks(platforms: Set<MusicPlatform>): Result<List<Track>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAlbums(platforms: Set<MusicPlatform>): Result<List<Album>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPlaylists(platforms: Set<MusicPlatform>): Result<List<Playlist>> {
        TODO("Not yet implemented")
    }

    override suspend fun getArtists(platforms: Set<MusicPlatform>): Result<List<Playlist>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAlbumById(albumId: String): Result<Album> {
        TODO("Not yet implemented")
    }

    override suspend fun getPlaylistById(playlistId: String): Result<Playlist> {
        TODO("Not yet implemented")
    }

    override suspend fun getArtistById(artistId: String): Result<Artist> {
        TODO("Not yet implemented")
    }

    override suspend fun getContentCount(
        platform: MusicPlatform,
        contentType: ContentType
    ): Result<Int> {
        TODO("Not yet implemented")
    }

    override suspend fun clearLocalCache(): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun searchContent(
        query: String,
        contentType: ContentType,
        platforms: Set<MusicPlatform>
    ): Result<List<MusicContent>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPlaylist(playlistId: String): Any {
        TODO("Not yet implemented")
    }

    override suspend fun getRecentContents(): List<MusicContent> {
        TODO("Not yet implemented")
    }

    override suspend fun getAlbumTracks(albumId: String): Result<List<Track>> {
        TODO("Not yet implemented")
    }
}