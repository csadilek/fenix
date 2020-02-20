/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix

import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.getSystemService
import mozilla.components.browser.errorpages.ErrorPages
import mozilla.components.browser.errorpages.ErrorType
import mozilla.components.concept.engine.EngineSession
import mozilla.components.concept.engine.request.RequestInterceptor
import org.mozilla.fenix.components.metrics.Event
import org.mozilla.fenix.ext.components
import org.mozilla.fenix.ext.isOnline
import org.mozilla.fenix.ext.settings
import org.mozilla.fenix.ui.robots.appContext

class AppRequestInterceptor(private val context: Context) : RequestInterceptor {
    override fun onLoadRequest(
        engineSession: EngineSession,
        uri: String,
        hasUserGesture: Boolean,
        isSameDomain: Boolean
    ): RequestInterceptor.InterceptionResponse? {
        return appContext.components.services.accountsAuthFeature.interceptor.onLoadRequest(
            engineSession, uri, hasUserGesture, isSameDomain)
    }
}
