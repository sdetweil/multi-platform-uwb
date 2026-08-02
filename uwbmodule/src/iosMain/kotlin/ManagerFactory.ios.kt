package com.dustedrob.uwb

actual class ManagerFactory {
    // One shared UWB manager so BleManager and DeviceDiscoveryManager see the same per-peer
    // sessions and connection configs.
    private val uwbManager = MultiplatformUwbManager()

    actual fun createUwbManager(): MultiplatformUwbManager = uwbManager

    actual fun createBleManager(config: BleDiscoveryConfig): BleManager =
        BleManager(config, uwbManager)
}
