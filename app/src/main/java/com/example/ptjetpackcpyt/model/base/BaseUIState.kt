package com.example.ptjetpackcpyt.model.base

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

/**
 * A generic, type-safe sealed class representing the state of a UI component or screen.
 *
 * Designed for Jetpack Compose state management, handling common asynchronous data states:
 * [None], [Loading], [Success], [Error], and [ErrorException].
 */
@Stable
sealed class BaseUIState<out T> {

    /**
     * Initial state before any request or operation has been triggered.
     */
    data object None : BaseUIState<Nothing>()

    /**
     * Represents that data is currently being fetched or processed.
     */
    data object Loading : BaseUIState<Nothing>()

    /**
     * Represents successful completion with result data.
     *
     * @param data The payload returned on success.
     */
    @Immutable
    data class Success<out T>(val data: T) : BaseUIState<T>()

    /**
     * Represents an error with an integer code and message.
     */
    @Immutable
    data class Error(val code: Int, val message: String) : BaseUIState<Nothing>()

    /**
     * Represents an error or failure state with an optional throwable cause.
     *
     * @param message Human-readable error message.
     * @param throwable Optional exception or error cause.
     */
    @Immutable
    data class ErrorException(
        val message: String,
        val throwable: Throwable? = null
    ) : BaseUIState<Nothing>()
}
