package net.jcip.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * SingleThreadRenderer
 * <p/>
 * Rendering page elements sequentially
 *
 * @author Brian Goetz and Tim Peierls
 */
public abstract class SingleThreadRenderer {

  // process rendering in parallel for cpu-usage
  void renderPage(CharSequence source) {
    // processing text is cpu-bound
    renderText(source);
    List<ImageData> imageData = new ArrayList<>();

    // getting images is io-bound
    for (ImageInfo imageInfo : scanForImageInfo(source)) {
      imageData.add(imageInfo.downloadImage());
    }

    for (ImageData data : imageData) {
      renderImage(data);
    }
  }

  abstract void renderText(CharSequence s);

  abstract List<ImageInfo> scanForImageInfo(CharSequence s);

  abstract void renderImage(ImageData i);

  interface ImageData {

  }

  interface ImageInfo {

    ImageData downloadImage();
  }
}
