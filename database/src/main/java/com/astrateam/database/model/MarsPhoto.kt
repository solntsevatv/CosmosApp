package com.astrateam.database.model

import java.util.*

class MarsPhoto {
    lateinit var url: String
    lateinit var earthDate: Date
    lateinit var camera: CameraType

    enum class CameraType {
        UNKNOWN,
        FHAZ,       // Front Hazard Avoidance Camera
        RHAZ,       // Rear Hazard Avoidance Camera
        MAST,       // Mast Camera
        CHEMCAM,    // Chemistry and Camera Complex
        MAHLI,      // Mars Hand Lens Imager
        MARDI,      // Mars Descent Imager
        NAVCAM,     // Navigation Camera
        PANCAM,     // Panoramic Camera
        MINITES     // Miniature Thermal Emission Spectrometer (Mini-TES)
    }
}
