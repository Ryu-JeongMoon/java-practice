package net.jcip.examples;

import static net.jcip.examples.LaunderThrowable.launderThrowable;

import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * basic.oop.Renderer
 * <p/>
 * Using CompletionService to render page elements as they become available
 *
 * @author Brian Goetz and Tim Peierls
 */
public abstract class Renderer {

  private final ExecutorService executor;

  Renderer(ExecutorService executor) {
    this.executor = executor;
  }

  void renderPage(CharSequence source) {
    final List<ImageInfo> info = scanForImageInfo(source);
    CompletionService<ImageData> completionService = new ExecutorCompletionService<>(executor);
    for (final ImageInfo imageInfo : info) {
      completionService.submit(imageInfo::downloadImage);
    }

    renderText(source);

    try {
      for (int t = 0, n = info.size(); t < n; t++) {
        Future<ImageData> f = completionService.take();
        ImageData imageData = f.get();
        renderImage(imageData);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    } catch (ExecutionException e) {
      throw launderThrowable(e.getCause());
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
