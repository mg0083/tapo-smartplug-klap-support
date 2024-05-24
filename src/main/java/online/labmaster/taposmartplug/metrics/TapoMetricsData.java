package online.labmaster.taposmartplug.metrics;

import online.labmaster.taposmartplug.api.inbound.CurrentPowerResponse;
import online.labmaster.taposmartplug.exception.TapoException;
import online.labmaster.taposmartplug.api.inbound.DeviceInfoResponse;
import online.labmaster.taposmartplug.api.inbound.EnergyUsageResponse;

public record TapoMetricsData(EnergyUsageResponse energyUsageResponse, DeviceInfoResponse deviceInfoResponse, CurrentPowerResponse currentPowerResponse) {

    public EnergyUsageResponse.EnergyUsage getEnergyUsage() {
        if (energyUsageResponse != null) {
            return energyUsageResponse.result;
        }
        throw new TapoException("cannot get energy usage, response is null");
    }


    public DeviceInfoResponse.DeviceInfo getDeviceInfo() {
        if (deviceInfoResponse != null) {
            return deviceInfoResponse.result;
        }
        throw new TapoException("cannot get device info, response is null");
    }

    public CurrentPowerResponse.CurrentPowerInfo getCurrentPowerInfo() {
        if (currentPowerResponse != null) {
            return currentPowerResponse.result;
        }
        throw new TapoException("cannot get current power info, response is null");
    }

}
