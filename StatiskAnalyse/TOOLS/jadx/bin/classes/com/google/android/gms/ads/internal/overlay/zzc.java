package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.baidu.location.b.g;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzid;
import gov.nist.core.Separators;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzgr
public class zzc extends zzi implements OnAudioFocusChangeListener, OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnVideoSizeChangedListener, SurfaceTextureListener {
    private static final Map<Integer, String> zzAO = new HashMap();
    private final zzp zzAP;
    private int zzAQ = 0;
    private int zzAR = 0;
    private MediaPlayer zzAS;
    private Uri zzAT;
    private int zzAU;
    private int zzAV;
    private int zzAW;
    private int zzAX;
    private int zzAY;
    private float zzAZ = PhotoViewAttacher.DEFAULT_MIN_SCALE;
    private boolean zzBa;
    private boolean zzBb;
    private int zzBc;
    private zzh zzBd;

    static {
        zzAO.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
        zzAO.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
        zzAO.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
        zzAO.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
        zzAO.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        zzAO.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        zzAO.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        zzAO.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzAO.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        zzAO.put(Integer.valueOf(g.I), "MEDIA_INFO_BUFFERING_START");
        zzAO.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        zzAO.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
        zzAO.put(Integer.valueOf(g.Z), "MEDIA_INFO_NOT_SEEKABLE");
        zzAO.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        zzAO.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        zzAO.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzc(Context context, zzp com_google_android_gms_ads_internal_overlay_zzp) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzAP = com_google_android_gms_ads_internal_overlay_zzp;
        this.zzAP.zza((zzi) this);
    }

    private void zzb(float f) {
        if (this.zzAS != null) {
            try {
                this.zzAS.setVolume(f, f);
                return;
            } catch (IllegalStateException e) {
                return;
            }
        }
        zzb.zzaH("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
    }

    private void zzeA() {
        zzb.v("AdMediaPlayerView audio focus lost");
        this.zzBb = false;
        zzeB();
    }

    private void zzeB() {
        if (this.zzBa || !this.zzBb) {
            zzb(0.0f);
        } else {
            zzb(this.zzAZ);
        }
    }

    private AudioManager zzeC() {
        return (AudioManager) getContext().getSystemService("audio");
    }

    private void zzes() {
        Throwable e;
        zzb.v("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzAT != null && surfaceTexture != null) {
            zzt(false);
            try {
                this.zzAS = new MediaPlayer();
                this.zzAS.setOnBufferingUpdateListener(this);
                this.zzAS.setOnCompletionListener(this);
                this.zzAS.setOnErrorListener(this);
                this.zzAS.setOnInfoListener(this);
                this.zzAS.setOnPreparedListener(this);
                this.zzAS.setOnVideoSizeChangedListener(this);
                this.zzAW = 0;
                this.zzAS.setDataSource(getContext(), this.zzAT);
                this.zzAS.setSurface(new Surface(surfaceTexture));
                this.zzAS.setAudioStreamType(3);
                this.zzAS.setScreenOnWhilePlaying(true);
                this.zzAS.prepareAsync();
                zzt(1);
            } catch (IOException e2) {
                e = e2;
                zzb.zzd("Failed to initialize MediaPlayer at " + this.zzAT, e);
                onError(this.zzAS, 1, 0);
            } catch (IllegalArgumentException e3) {
                e = e3;
                zzb.zzd("Failed to initialize MediaPlayer at " + this.zzAT, e);
                onError(this.zzAS, 1, 0);
            }
        }
    }

    private void zzet() {
        if (zzew() && this.zzAS.getCurrentPosition() > 0 && this.zzAR != 3) {
            zzb.v("AdMediaPlayerView nudging MediaPlayer");
            zzb(0.0f);
            this.zzAS.start();
            int currentPosition = this.zzAS.getCurrentPosition();
            long currentTimeMillis = zzp.zzbz().currentTimeMillis();
            while (zzew() && this.zzAS.getCurrentPosition() == currentPosition) {
                if (zzp.zzbz().currentTimeMillis() - currentTimeMillis > 250) {
                    break;
                }
            }
            this.zzAS.pause();
            zzeB();
        }
    }

    private void zzeu() {
        AudioManager zzeC = zzeC();
        if (zzeC != null && !this.zzBb) {
            if (zzeC.requestAudioFocus(this, 3, 2) == 1) {
                zzez();
            } else {
                zzb.zzaH("AdMediaPlayerView audio focus request failed");
            }
        }
    }

    private void zzev() {
        zzb.v("AdMediaPlayerView abandon audio focus");
        AudioManager zzeC = zzeC();
        if (zzeC != null && this.zzBb) {
            if (zzeC.abandonAudioFocus(this) == 1) {
                this.zzBb = false;
            } else {
                zzb.zzaH("AdMediaPlayerView abandon audio focus failed");
            }
        }
    }

    private boolean zzew() {
        return (this.zzAS == null || this.zzAQ == -1 || this.zzAQ == 0 || this.zzAQ == 1) ? false : true;
    }

    private void zzez() {
        zzb.v("AdMediaPlayerView audio focus gained");
        this.zzBb = true;
        zzeB();
    }

    private void zzt(int i) {
        if (i == 3) {
            this.zzAP.zzfe();
        } else if (this.zzAQ == 3 && i != 3) {
            this.zzAP.zzff();
        }
        this.zzAQ = i;
    }

    private void zzt(boolean z) {
        zzb.v("AdMediaPlayerView release");
        if (this.zzAS != null) {
            this.zzAS.reset();
            this.zzAS.release();
            this.zzAS = null;
            zzt(0);
            if (z) {
                this.zzAR = 0;
                zzu(0);
            }
            zzev();
        }
    }

    private void zzu(int i) {
        this.zzAR = i;
    }

    public int getCurrentPosition() {
        return zzew() ? this.zzAS.getCurrentPosition() : 0;
    }

    public int getDuration() {
        return zzew() ? this.zzAS.getDuration() : -1;
    }

    public int getVideoHeight() {
        return this.zzAS != null ? this.zzAS.getVideoHeight() : 0;
    }

    public int getVideoWidth() {
        return this.zzAS != null ? this.zzAS.getVideoWidth() : 0;
    }

    public void onAudioFocusChange(int focusChange) {
        if (focusChange > 0) {
            zzez();
        } else if (focusChange < 0) {
            zzeA();
        }
    }

    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        this.zzAW = percent;
    }

    public void onCompletion(MediaPlayer mp) {
        zzb.v("AdMediaPlayerView completion");
        zzt(5);
        zzu(5);
        zzid.zzIE.post(new Runnable(this) {
            final /* synthetic */ zzc zzBe;

            {
                this.zzBe = r1;
            }

            public void run() {
                if (this.zzBe.zzBd != null) {
                    this.zzBe.zzBd.zzeT();
                }
            }
        });
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        final String str = (String) zzAO.get(Integer.valueOf(what));
        final String str2 = (String) zzAO.get(Integer.valueOf(extra));
        zzb.zzaH("AdMediaPlayerView MediaPlayer error: " + str + Separators.COLON + str2);
        zzt(-1);
        zzu(-1);
        zzid.zzIE.post(new Runnable(this) {
            final /* synthetic */ zzc zzBe;

            public void run() {
                if (this.zzBe.zzBd != null) {
                    this.zzBe.zzBd.zzh(str, str2);
                }
            }
        });
        return true;
    }

    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        String str = (String) zzAO.get(Integer.valueOf(extra));
        zzb.v("AdMediaPlayerView MediaPlayer info: " + ((String) zzAO.get(Integer.valueOf(what))) + Separators.COLON + str);
        return true;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int defaultSize = getDefaultSize(this.zzAU, widthMeasureSpec);
        int defaultSize2 = getDefaultSize(this.zzAV, heightMeasureSpec);
        if (this.zzAU > 0 && this.zzAV > 0) {
            int mode = MeasureSpec.getMode(widthMeasureSpec);
            int size = MeasureSpec.getSize(widthMeasureSpec);
            int mode2 = MeasureSpec.getMode(heightMeasureSpec);
            defaultSize2 = MeasureSpec.getSize(heightMeasureSpec);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.zzAU * defaultSize2 < this.zzAV * size) {
                    defaultSize = (this.zzAU * defaultSize2) / this.zzAV;
                } else if (this.zzAU * defaultSize2 > this.zzAV * size) {
                    defaultSize2 = (this.zzAV * size) / this.zzAU;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                defaultSize = (this.zzAV * size) / this.zzAU;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.zzAU * defaultSize2) / this.zzAV;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i = this.zzAU;
                defaultSize = this.zzAV;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = i;
                } else {
                    defaultSize = (this.zzAU * defaultSize2) / this.zzAV;
                }
                if (mode == Integer.MIN_VALUE && r1 > size) {
                    defaultSize2 = (this.zzAV * size) / this.zzAU;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (VERSION.SDK_INT == 16) {
            if ((this.zzAX > 0 && this.zzAX != defaultSize) || (this.zzAY > 0 && this.zzAY != defaultSize2)) {
                zzet();
            }
            this.zzAX = defaultSize;
            this.zzAY = defaultSize2;
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        zzb.v("AdMediaPlayerView prepared");
        zzt(2);
        this.zzAP.zzeR();
        zzid.zzIE.post(new Runnable(this) {
            final /* synthetic */ zzc zzBe;

            {
                this.zzBe = r1;
            }

            public void run() {
                if (this.zzBe.zzBd != null) {
                    this.zzBe.zzBd.zzeR();
                }
            }
        });
        this.zzAU = mediaPlayer.getVideoWidth();
        this.zzAV = mediaPlayer.getVideoHeight();
        if (this.zzBc != 0) {
            seekTo(this.zzBc);
        }
        zzet();
        zzb.zzaG("AdMediaPlayerView stream dimensions: " + this.zzAU + " x " + this.zzAV);
        if (this.zzAR == 3) {
            play();
        }
        zzeu();
        zzeB();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        zzb.v("AdMediaPlayerView surface created");
        zzes();
        zzid.zzIE.post(new Runnable(this) {
            final /* synthetic */ zzc zzBe;

            {
                this.zzBe = r1;
            }

            public void run() {
                if (this.zzBe.zzBd != null) {
                    this.zzBe.zzBd.zzeQ();
                }
            }
        });
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        zzb.v("AdMediaPlayerView surface destroyed");
        if (this.zzAS != null && this.zzBc == 0) {
            this.zzBc = this.zzAS.getCurrentPosition();
        }
        zzid.zzIE.post(new Runnable(this) {
            final /* synthetic */ zzc zzBe;

            {
                this.zzBe = r1;
            }

            public void run() {
                if (this.zzBe.zzBd != null) {
                    this.zzBe.zzBd.onPaused();
                    this.zzBe.zzBd.zzeU();
                }
            }
        });
        zzt(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int w, int h) {
        Object obj = 1;
        zzb.v("AdMediaPlayerView surface changed");
        Object obj2 = this.zzAR == 3 ? 1 : null;
        if (!(this.zzAU == w && this.zzAV == h)) {
            obj = null;
        }
        if (this.zzAS != null && obj2 != null && r1 != null) {
            if (this.zzBc != 0) {
                seekTo(this.zzBc);
            }
            play();
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        this.zzAP.zzb(this);
    }

    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
        zzb.v("AdMediaPlayerView size changed: " + width + " x " + height);
        this.zzAU = mp.getVideoWidth();
        this.zzAV = mp.getVideoHeight();
        if (this.zzAU != 0 && this.zzAV != 0) {
            requestLayout();
        }
    }

    public void pause() {
        zzb.v("AdMediaPlayerView pause");
        if (zzew() && this.zzAS.isPlaying()) {
            this.zzAS.pause();
            zzt(4);
            zzid.zzIE.post(new Runnable(this) {
                final /* synthetic */ zzc zzBe;

                {
                    this.zzBe = r1;
                }

                public void run() {
                    if (this.zzBe.zzBd != null) {
                        this.zzBe.zzBd.onPaused();
                    }
                }
            });
        }
        zzu(4);
    }

    public void play() {
        zzb.v("AdMediaPlayerView play");
        if (zzew()) {
            this.zzAS.start();
            zzt(3);
            zzid.zzIE.post(new Runnable(this) {
                final /* synthetic */ zzc zzBe;

                {
                    this.zzBe = r1;
                }

                public void run() {
                    if (this.zzBe.zzBd != null) {
                        this.zzBe.zzBd.zzeS();
                    }
                }
            });
        }
        zzu(3);
    }

    public void seekTo(int millis) {
        zzb.v("AdMediaPlayerView seek " + millis);
        if (zzew()) {
            this.zzAS.seekTo(millis);
            this.zzBc = 0;
            return;
        }
        this.zzBc = millis;
    }

    public void setMimeType(String mimeType) {
    }

    public void setVideoPath(String path) {
        setVideoURI(Uri.parse(path));
    }

    public void setVideoURI(Uri uri) {
        this.zzAT = uri;
        this.zzBc = 0;
        zzes();
        requestLayout();
        invalidate();
    }

    public void stop() {
        zzb.v("AdMediaPlayerView stop");
        if (this.zzAS != null) {
            this.zzAS.stop();
            this.zzAS.release();
            this.zzAS = null;
            zzt(0);
            zzu(0);
            zzev();
        }
        this.zzAP.onStop();
    }

    public String toString() {
        return getClass().getName() + Separators.AT + Integer.toHexString(hashCode());
    }

    public void zza(float f) {
        this.zzAZ = f;
        zzeB();
    }

    public void zza(zzh com_google_android_gms_ads_internal_overlay_zzh) {
        this.zzBd = com_google_android_gms_ads_internal_overlay_zzh;
    }

    public String zzer() {
        return "MediaPlayer";
    }

    public void zzex() {
        this.zzBa = true;
        zzeB();
    }

    public void zzey() {
        this.zzBa = false;
        zzeB();
    }
}
