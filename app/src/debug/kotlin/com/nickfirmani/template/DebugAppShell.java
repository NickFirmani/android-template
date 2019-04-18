package com.nickfirmani.template;

import com.facebook.buck.android.support.exopackage.ExopackageApplication;

public class DebugAppShell extends ExopackageApplication {

  public DebugAppShell() {
    super(
      // This is passed as a string so the shell application does not
      // have a binary dependency on your ApplicationLike class.
      /* applicationLikeClassName */
      "com.nickfirmani.template.DebugTemplateApp",

      // The package for this BuildConfig class must match the package
      // from the android_build_config() rule. The value of the flags
      // will be set based on the "exopackage_modes" argument to
      // android_binary().
      // This will also show up as red in your editor, unless you run `buckw project`
      // TODO: Convert this file to kotlin (and configure okbuck to pick it up)
//      com.nickfirmani.template.BuildConfig.EXOPACKAGE_FLAGS);
      1); // ??
  }
}
