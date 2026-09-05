package com.github.catvod.spider;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Init {
    public Application c;
    public Activity d;
    public final Handler b = new Handler(Looper.getMainLooper());
    public final ExecutorService a = Executors.newFixedThreadPool(5);

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    class Loader {
        public static volatile Init a = new Init();
    }

    public static Activity activity() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", null).invoke(null, null);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(objInvoke);
            if (map != null) {
                for (Object obj : map.values()) {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        return (Activity) declaredField3.get(obj);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        Activity activity = get().d;
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        return activity;
    }

    public static Application context() {
        return get().c;
    }

    public static void execute(Runnable runnable) {
        get().a.execute(runnable);
    }

    public static Init get() {
        return Loader.a;
    }

    public static void init(Context context) {
        get().c = (Application) context;
        Proxy.init();
        Init init = get();
        Application application = init.c;
        if (application == null) {
            return;
        }
        try {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.github.catvod.spider.Init.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    Init.this.d = activity;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Init init2 = Init.this;
                    if (activity == init2.d) {
                        init2.d = null;
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    Init.this.d = activity;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    Init.this.d = activity;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void post(Runnable runnable, int i) {
        get().b.postDelayed(runnable, i);
    }

    public static void post(Runnable runnable) {
        get().b.post(runnable);
    }
}
