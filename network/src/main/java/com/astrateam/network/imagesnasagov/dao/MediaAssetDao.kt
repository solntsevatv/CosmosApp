package com.astrateam.network.imagesnasagov.dao

data class MediaAssetDao(
    var data: List<MediaAssetDataDao>,
    var href: String,
    var links: List<MediaAssetLinkDao>
)
