package com.astrateam.network.imagesnasagov.dao

data class MediaAssetsListDao(
    val version: String,
    val href: String,
    val metadata: MediaAssetsListMetaDataDao,
    val links: List<MediaAssetsListLinkDao>,
    val items: List<MediaAssetDao>
)
