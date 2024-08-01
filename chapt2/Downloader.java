class Downloader extends Thread {
  private InputStream in;
  private OutputStream out;
  private ArrayList<ProgressListener> listeners;

  public Downloader(URL url, String outputFile) throws IOException {
    in = url.openConnection().getInputStream();
    out = new FileOutputStream(outputFile);
    listeners = new ArrayList<ProgressListener>();
  }

  public synchronized void addListener(ProgressListener listener) {
    listeners.add(listener);
  }

  public synchronized void removeListener(ProgressListener listener) {
    listeners.remove(listener)
  }

  private synchronized void updateProgress(int n) {
    ArrayList<ProgressListener> listnersCopy;
    synchronized(this) {
      listnersCopy = (ArrayList<ProgressListener>)listeners.clone();
    }
    for (ProgressListener listener: listenersCopy)
      listener.onProgress(n);
  }

  public void run() {
    in n = 0  total = 0;
    byte[] buffer = new byte[1024];

    try {
      while((n = in.read(buffer)) != -1) {
        out.write(buffer, 0, n);
        total += n;
        updateProgress(total);
      }
      out.flush();
    } catch (IOException e) {}
  }
}
