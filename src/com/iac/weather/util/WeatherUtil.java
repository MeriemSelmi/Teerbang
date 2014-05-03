
package com.iac.weather.util;

import android.annotation.SuppressLint;


@SuppressLint("DefaultLocale")
public class WeatherUtil {

	public static String modifyDescription(String descr, String option) {
		String modDesc = descr;

		if (option != null) {
			if (descr != null) {
				if (option.equalsIgnoreCase("Default")) {
					if (WeatherConstants.ATM_FOG.equalsIgnoreCase(descr)) {
						modDesc = "Fog!";
					}
					if (WeatherConstants.ATM_HAZE.equalsIgnoreCase(descr)) {
						modDesc = "hazy";
					}
					if (WeatherConstants.ATM_MIST.equalsIgnoreCase(descr)) {
						modDesc = "Tiny water droplets";
					}
					if (WeatherConstants.ATM_SAND_DUST
							.equalsIgnoreCase(descr)) {
						modDesc = "whirls of dust";
					}
					if (WeatherConstants.ATM_SMOKE.equalsIgnoreCase(descr)) {
						modDesc = "smoke";
					}
					if (WeatherConstants.CLD_BROKEN.equalsIgnoreCase(descr)) {
						modDesc = "broken clouds";
					}
					if (WeatherConstants.CLD_CLEAR.equalsIgnoreCase(descr)) {
						modDesc = "Sky is clear";
					}
					if (WeatherConstants.CLD_FEW.equalsIgnoreCase(descr)) {
						modDesc = "Few clouds";
					}
					if (WeatherConstants.CLD_OVERCAST
							.equalsIgnoreCase(descr)) {
						modDesc = "overcast";
					}
					if (WeatherConstants.CLD_SCAT.equalsIgnoreCase(descr)) {
						modDesc = "Clouds scattered everywhere";
					}
					if (WeatherConstants.DRIZ.equalsIgnoreCase(descr)) {
						modDesc = "It decides to drizzle";
					}
					if (WeatherConstants.DRIZ_HEAVY_INT
							.equalsIgnoreCase(descr)) {
						modDesc = "Heavy drizzle";
					}
					if (WeatherConstants.DRIZ_HEAVY_INT_RAIN
							.equalsIgnoreCase(descr)) {
						modDesc = "Heavy  intensity rain and drizzle";
					}
					if (WeatherConstants.DRIZ_LIGHT_INT
							.equalsIgnoreCase(descr)) {
						modDesc = "Heavy intensity rain and drizzle";
					}
					if (WeatherConstants.DRIZ_LIGHT_INT_RAIN
							.equalsIgnoreCase(descr)) {
						modDesc = "Light drizzle";
					}
					if (WeatherConstants.DRIZ_RAIN.equalsIgnoreCase(descr)) {
						modDesc = "Light drizzle";
					}
					if (WeatherConstants.DRIZ_SHOWER.equalsIgnoreCase(descr)) {
						modDesc = "drizzle with shower";
					}
					if (WeatherConstants.EXT_COLD.equalsIgnoreCase(descr)) {
						modDesc = "Cold freezer";
					}
					if (WeatherConstants.EXT_HAIL.equalsIgnoreCase(descr)) {
						modDesc = "hail storm";
					}
					if (WeatherConstants.EXT_HOT.equalsIgnoreCase(descr)) {
						modDesc = "Hot";
					}
					if (WeatherConstants.EXT_HURR.equalsIgnoreCase(descr)) {
						modDesc = "hurricane";
					}
					if (WeatherConstants.EXT_TORNADO.equalsIgnoreCase(descr)) {
						modDesc = "tornado";
					}
					if (WeatherConstants.EXT_TROP_STORM
							.equalsIgnoreCase(descr)) {
						modDesc = "A tropical";
					}
					if (WeatherConstants.EXT_WINDY.equalsIgnoreCase(descr)) {
						modDesc = "winds tearing it all apart";
					}
					if (WeatherConstants.RAIN_EXTREME
							.equalsIgnoreCase(descr)) {
						modDesc = "Extreme rain";
					}
					if (WeatherConstants.RAIN_HEAVY.equalsIgnoreCase(descr)) {
						modDesc = "Some heavy rain";
					}
					if (WeatherConstants.RAIN_HEAVY_INT
							.equalsIgnoreCase(descr)) {
						modDesc = "Heave intensity rain";
					}
					if (WeatherConstants.RAIN_HEAVY_INT_SHOW
							.equalsIgnoreCase(descr)) {
						modDesc = "intensity rain with showers";
					}
					if (WeatherConstants.RAIN_LIGHT.equalsIgnoreCase(descr)) {
						modDesc = "Weakass rain";
					}
					if (WeatherConstants.RAIN_LIGHT_INT_SHOW
							.equalsIgnoreCase(descr)) {
						modDesc = "Weakass rain with showers";
					}
					if (WeatherConstants.RAIN_MOD.equalsIgnoreCase(descr)) {
						modDesc = "rain in moderate amounts.";
					}
					if (WeatherConstants.RAIN_SHOW.equalsIgnoreCase(descr)) {
						modDesc = "Shower rain";
					}
					if (WeatherConstants.SNOW.equalsIgnoreCase(descr)) {
						modDesc = "Snow";
					}
					if (WeatherConstants.SNOW_HEAVY.equalsIgnoreCase(descr)) {
						modDesc = "Heavyass snow";
					}
					if (WeatherConstants.SNOW_LIGHT.equalsIgnoreCase(descr)) {
						modDesc = "Weakass snow";
					}
					if (WeatherConstants.SNOW_SHOW.equalsIgnoreCase(descr)) {
						modDesc = "shower snow";
					}
					if (WeatherConstants.SNOW_SLEET.equalsIgnoreCase(descr)) {
						modDesc = "snow sleet";
					}
					if (WeatherConstants.THUN.equalsIgnoreCase(descr)) {
						modDesc = "Fucking thunder";
					}
					if (WeatherConstants.THUN_DRIZ.equalsIgnoreCase(descr)) {
						modDesc = "Thunder with drizzle";
					}
					if (WeatherConstants.THUN_HEAVY.equalsIgnoreCase(descr)) {
						modDesc = "Heavy thunderstorm";
					}
					if (WeatherConstants.THUN_HEAVY_DRIZ
							.equalsIgnoreCase(descr)) {
						modDesc = "Thunderstorm with goddamn heavyass drizzle";
					}
					if (WeatherConstants.THUN_HEAVY_RAIN
							.equalsIgnoreCase(descr)) {
						modDesc = "Thuderstorm with heavyass rain";
					}
					if (WeatherConstants.THUN_LIGHT.equalsIgnoreCase(descr)) {
						modDesc = "Weakass thunderstorm";
					}
					if (WeatherConstants.THUN_LIGHT_DRIZ
							.equalsIgnoreCase(descr)) {
						modDesc = "Thunderstorm with weakass drizzle";
					}
					if (WeatherConstants.THUN_LIGHT_RAIN
							.equalsIgnoreCase(descr)) {
						modDesc = "Thunderstorm with weakass rain";
					}
					if (WeatherConstants.THUN_RAGGED.equalsIgnoreCase(descr)) {
						modDesc = "Ragged thunderstorm";
					}
					if (WeatherConstants.THUN_RAIN.equalsIgnoreCase(descr)) {
						modDesc = "Thunderstorm with rain";
					}
				
				

				
				}
			}

		}
		return modDesc.toUpperCase();
	}
}
