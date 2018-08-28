package org.athaliapps.twilist.Utils

import kotlinx.coroutines.experimental.Job

data class CoroutineHelper(val ayoh: suspend () -> Unit)
{
    var job : Job? = null
}