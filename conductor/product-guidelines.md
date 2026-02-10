# Carteira do Cabral (FlashGastos) - Product Guidelines

## 1. Visual Identity ("Tactile Pop")
*   **Philosophy:** High contrast, clear boundaries, and immediate visual feedback. The UI should feel "clickable" and physical, rejecting flat abstraction for tangible interaction.
*   **Color Palette:**
    *   **Primary:** Indigo-500 (`#6366F1`) - Used for primary actions and active states.
    *   **Secondary/Accent:** Pink-500 (`#EC4899`) - Used for highlights and micro-interactions.
    *   **Success:** Emerald-500 (`#10B981`) - Used for positive balances and confirmation animations.
    *   **Background:** Slate-50 (`#F8FAFC`) - A clean, off-white base.
    *   **Surface:** Slate-100 (`#F1F5F9`) - Used for secondary buttons and card backgrounds.
*   **Typography:** System Default (Roboto/Inter) with bold weights (700) for display values and semi-bold (600) for headers to ensure readability at a glance.
*   **Interaction Design:**
    *   **Hit Targets:** Large, finger-friendly buttons (min 48dp).
    *   **Shape:** Generous rounded corners (24dp+) on buttons and cards.
    *   **Motion:** Spring animations for button presses and transitions.
    *   **Haptics:** Tactile vibration feedback on every keypad tap and save action.

## 2. User Experience (UX) Principles
*   **The 3-Second Rule:** Every core interaction (logging an expense) must be completable within 3 seconds.
*   **Input-First:** The app launches directly to the input method (Calculator Keypad), bypassing dashboards or lists.
*   **Frictionless Entry:** Minimize steps. Auto-decimal handling (typing `250` -> `2.50`) and one-tap category selection.
*   **Offline Trust:** No loading spinners, no "syncing" states. All actions are instantaneous and local.
*   **Context Aware:** The app anticipates needs (e.g., suggesting "Groceries" when at the supermarket) to reduce cognitive load.

## 3. Communication Tone
*   **Direct & Minimal:** No onboarding fluff. Labels are concise (e.g., "Food" instead of "Dining & Restaurants").
*   **Reassuring:** Confirmations are clear and positive (e.g., Green Check + Haptic "Thud").
*   **Private:** Language emphasizes user ownership (e.g., "Your device," "Local backup").

## 4. Coding Standards (Android Native)
*   **Language:** Kotlin (Strict typing).
*   **UI Toolkit:** Jetpack Compose (Declarative UI).
*   **Architecture:** MVVM + Clean Architecture (Separation of concerns).
*   **Async:** Coroutines + Flow.
*   **Persistence:** Room Database (SQLite).
*   **Dependency Injection:** Hilt.
*   **Linting:** Ktlint for style enforcement.