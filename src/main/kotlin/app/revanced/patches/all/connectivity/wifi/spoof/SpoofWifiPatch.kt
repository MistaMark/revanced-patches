package app.revanced.patches.all.connectivity.wifi.spoof

import app.revanced.patches.all.misc.transformation.IMethodCall
import app.revanced.patches.all.misc.transformation.filterMapInstruction35c
import app.revanced.patches.all.misc.transformation.transformInstructionsPatch

internal var INTEGRATIONS_CLASS_DESCRIPTOR_PREFIX = "Lapp/revanced/integrations/all/connectivity/wifi/spoof/SpoofWifiPatch"
    private set

internal var INTEGRATIONS_CLASS_DESCRIPTOR = "$INTEGRATIONS_CLASS_DESCRIPTOR_PREFIX;"
    private set

@Suppress("unused")
val spoofWifiPatch = transformInstructionsPatch(
    filterMap = { classDef, method, instruction, instructionIndex ->
        filterMapInstruction35c<MethodCall>(
            INTEGRATIONS_CLASS_DESCRIPTOR_PREFIX,
            classDef,
            instruction,
            instructionIndex
        )
    },
    transform = { mutableMethod, entry ->
        val (methodType, instruction, instructionIndex) = entry
        methodType.replaceInvokeVirtualWithIntegrations(
            INTEGRATIONS_CLASS_DESCRIPTOR,
            mutableMethod,
            instruction,
            instructionIndex
        )
    }
)

// Information about method calls we want to replace
private enum class MethodCall(
    override val definedClassName: String,
    override val methodName: String,
    override val methodParams: Array<String>,
    override val returnType: String,
) : IMethodCall {
    GetSystemService1(
        "Landroid/content/Context;",
        "getSystemService",
        arrayOf("Ljava/lang/String;"),
        "Ljava/lang/Object;",
    ),
    GetSystemService2(
        "Landroid/content/Context;",
        "getSystemService",
        arrayOf("Ljava/lang/Class;"),
        "Ljava/lang/Object;",
    ),
    GetActiveNetworkInfo(
        "Landroid/net/ConnectivityManager;",
        "getActiveNetworkInfo",
        arrayOf(),
        "Landroid/net/NetworkInfo;",
    ),
    IsConnected(
        "Landroid/net/NetworkInfo;",
        "isConnected",
        arrayOf(),
        "Z",
    ),
    IsConnectedOrConnecting(
        "Landroid/net/NetworkInfo;",
        "isConnectedOrConnecting",
        arrayOf(),
        "Z",
    ),
    IsAvailable(
        "Landroid/net/NetworkInfo;",
        "isAvailable",
        arrayOf(),
        "Z",
    ),
    GetState(
        "Landroid/net/NetworkInfo;",
        "getState",
        arrayOf(),
        "Landroid/net/NetworkInfo\$State;",
    ),
    GetDetailedState(
        "Landroid/net/NetworkInfo;",
        "getDetailedState",
        arrayOf(),
        "Landroid/net/NetworkInfo\$DetailedState;",
    ),
    IsActiveNetworkMetered(
        "Landroid/net/ConnectivityManager;",
        "isActiveNetworkMetered",
        arrayOf(),
        "Z",
    ),
    GetActiveNetwork(
        "Landroid/net/ConnectivityManager;",
        "getActiveNetwork",
        arrayOf(),
        "Landroid/net/Network;",
    ),
    GetNetworkInfo(
        "Landroid/net/ConnectivityManager;",
        "getNetworkInfo",
        arrayOf("Landroid/net/Network;"),
        "Landroid/net/NetworkInfo;",
    ),
    HasTransport(
        "Landroid/net/NetworkCapabilities;",
        "hasTransport",
        arrayOf("I"),
        "Z",
    ),
    HasCapability(
        "Landroid/net/NetworkCapabilities;",
        "hasCapability",
        arrayOf("I"),
        "Z",
    ),
    RegisterBestMatchingNetworkCallback(
        "Landroid/net/ConnectivityManager;",
        "registerBestMatchingNetworkCallback",
        arrayOf(
            "Landroid/net/NetworkRequest;",
            "Landroid/net/ConnectivityManager\$NetworkCallback;",
            "Landroid/os/Handler;"
        ),
        "V",
    ),
    RegisterDefaultNetworkCallback1(
        "Landroid/net/ConnectivityManager;",
        "registerDefaultNetworkCallback",
        arrayOf("Landroid/net/ConnectivityManager\$NetworkCallback;"),
        "V",
    ),
    RegisterDefaultNetworkCallback2(
        "Landroid/net/ConnectivityManager;",
        "registerDefaultNetworkCallback",
        arrayOf("Landroid/net/ConnectivityManager\$NetworkCallback;", "Landroid/os/Handler;"),
        "V",
    ),
    RegisterNetworkCallback1(
        "Landroid/net/ConnectivityManager;",
        "registerNetworkCallback",
        arrayOf("Landroid/net/NetworkRequest;", "Landroid/net/ConnectivityManager\$NetworkCallback;"),
        "V",
    ),
    RegisterNetworkCallback2(
        "Landroid/net/ConnectivityManager;",
        "registerNetworkCallback",
        arrayOf("Landroid/net/NetworkRequest;", "Landroid/app/PendingIntent;"),
        "V",
    ),
    RegisterNetworkCallback3(
        "Landroid/net/ConnectivityManager;",
        "registerNetworkCallback",
        arrayOf(
            "Landroid/net/NetworkRequest;",
            "Landroid/net/ConnectivityManager\$NetworkCallback;",
            "Landroid/os/Handler;"
        ),
        "V",
    ),
    RequestNetwork1(
        "Landroid/net/ConnectivityManager;",
        "requestNetwork",
        arrayOf("Landroid/net/NetworkRequest;", "Landroid/net/ConnectivityManager\$NetworkCallback;"),
        "V",
    ),
    RequestNetwork2(
        "Landroid/net/ConnectivityManager;",
        "requestNetwork",
        arrayOf("Landroid/net/NetworkRequest;", "Landroid/net/ConnectivityManager\$NetworkCallback;", "I"),
        "V",
    ),
    RequestNetwork3(
        "Landroid/net/ConnectivityManager;",
        "requestNetwork",
        arrayOf(
            "Landroid/net/NetworkRequest;",
            "Landroid/net/ConnectivityManager\$NetworkCallback;",
            "Landroid/os/Handler;"
        ),
        "V",
    ),
    RequestNetwork4(
        "Landroid/net/ConnectivityManager;",
        "requestNetwork",
        arrayOf("Landroid/net/NetworkRequest;", "Landroid/app/PendingIntent;"),
        "V",
    ),
    RequestNetwork5(
        "Landroid/net/ConnectivityManager;",
        "requestNetwork",
        arrayOf(
            "Landroid/net/NetworkRequest;",
            "Landroid/net/ConnectivityManager\$NetworkCallback;",
            "Landroid/os/Handler;",
            "I"
        ),
        "V",
    ),
    UnregisterNetworkCallback1(
        "Landroid/net/ConnectivityManager;",
        "unregisterNetworkCallback",
        arrayOf("Landroid/net/ConnectivityManager\$NetworkCallback;"),
        "V",
    ),
    UnregisterNetworkCallback2(
        "Landroid/net/ConnectivityManager;",
        "unregisterNetworkCallback",
        arrayOf("Landroid/app/PendingIntent;"),
        "V",
    );
}