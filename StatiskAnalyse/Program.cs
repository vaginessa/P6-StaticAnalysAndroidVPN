using System;
using System.Collections.Specialized;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace StatiskAnalyse
{
    class Program
    {
        #region Permissions

        private static string[] _androidPermissions = {
            "ACCESS_LOCATION_EXTRA_COMMANDS",
            "ACCESS_NETWORK_STATE",
            "ACCESS_NOTIFICATION_POLICY",
            "ACCESS_WIFI_STATE",
            "BLUETOOTH",
            "BLUETOOTH_ADMIN",
            "BROADCAST_STICKY",
            "CHANGE_NETWORK_STATE",
            "CHANGE_WIFI_MULTICAST_STATE",
            "CHANGE_WIFI_STATE",
            "DISABLE_KEYGUARD",
            "EXPAND_STATUS_BAR",
            "GET_PACKAGE_SIZE",
            "INSTALL_SHORTCUT",
            "INTERNET",
            "KILL_BACKGROUND_PROCESSES",
            "MODIFY_AUDIO_SETTINGS",
            "NFC",
            "READ_SYNC_SETTINGS",
            "READ_SYNC_STATS",
            "RECEIVE_BOOT_COMPLETED",
            "REORDER_TASKS",
            "REQUEST_IGNORE_BATTERY_OPTIMIZATIONS",
            "REQUEST_INSTALL_PACKAGES",
            "SET_ALARM",
            "SET_TIME_ZONE",
            "SET_WALLPAPER",
            "SET_WALLPAPER_HINTS",
            "TRANSMIT_IR",
            "UNINSTALL_SHORTCUT",
            "USE_FINGERPRINT",
            "VIBRATE",
            "WAKE_LOCK",
            "WRITE_SYNC_SETTINGS"
        };

        #endregion

        static void Main(string[] args)
        {
            var useLibraries = new[] { "java/lang/Thread", "java/lang/reflect/Method", "java/lang/ClassLoader", "java/lang/Runtime;->exec", "https://", "SSLv2", "SSLv3", "Runtime.getRuntime()", ".exec(" };
            var lookFor = useLibraries.Concat(_androidPermissions).ToArray();

            var apks = Directory.EnumerateFiles("C:\\Users\\Malte\\Desktop\\VPNAPKSTOTEST");
            foreach (var apk in apks)
            {
                try
                {
                    ApkAnalysis.LoadApkJadx(apk, true, useLibraries).GenerateReport();
                }
                catch (Exception exception)
                {
                    Console.WriteLine("ERROR LOADING " + apk); 
                }
            }
            Console.WriteLine("\nDone with operations");
            Console.ReadKey();
        }

    }
}
