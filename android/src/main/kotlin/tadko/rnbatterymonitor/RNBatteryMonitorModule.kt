package tadko.rnbatterymonitor

import com.facebook.react.bridge.*
import java.util.*


class RNBatteryMonitorModule(var reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    private var batteryMonitor: RNBatteryMonitor = RNBatteryMonitor(reactContext)

    override fun getName(): String {
        return Constants.APP_NAME
    }

    override fun initialize() {
        super.initialize()
        this.reactContext.addLifecycleEventListener(batteryMonitor)
    }


    override fun getConstants(): Map<String, Any>? {
        val constants: MutableMap<String, Any> = HashMap()
        constants["BATTERY_CHANGE_EVENT"] = Constants.EVENT_NAME
        return constants
    }

    @ReactMethod
    fun getBatteryState(promise: Promise) {
        batteryMonitor.getBatteryState(promise)
    }
    
    
    @ReactMethod
    fun addListener(eventName: String): void {
        // Keep: Required for RN built in Event Emitter Calls.
    }

    @ReactMethod
    fun removeListeners(count: Integer): void {
        // Keep: Required for RN built in Event Emitter Calls.
    }
}
