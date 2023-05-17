package app.revanced.patches.youtube.interaction.seekbar.annotation

import app.revanced.patcher.annotation.Compatibility
import app.revanced.patcher.annotation.Package

@Compatibility([Package("com.google.android.youtube", arrayOf("18.16.37"))])
@Target(AnnotationTarget.CLASS)
internal annotation class SeekbarTappingCompatibility

