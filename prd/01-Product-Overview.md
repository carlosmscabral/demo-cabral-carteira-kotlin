# 01-Product-Overview.md

## 1. Problem Statement

The "Friction Gap" is the primary reason personal finance tracking fails. Current solutions fall into two flawed categories:
1.  **Manual Entry (Excel/Basic Apps):** High friction. Users must navigate menus, wait for splash screens, and manually categorize every cent. This leads to "tracking fatigue" where users stop recording after a few days.
2.  **Automated Entry (Bank Sync/Regex):** Fragile and intrusive. Bank APIs frequently break, and reading SMS/Notifications via Regex is increasingly blocked by modern OS privacy layers. Many users are also uncomfortable sharing banking credentials.

**The 3-Second Rule:** If a transaction takes more than 3 seconds to log, the user will eventually quit. "Carteira do Cabral" (Concept: **1Click Money**) pivots from the challenge of *automation* to the challenge of *extreme friction reduction*.

## 2. Solution

**1Click Money** is an "Input-First" Android application designed for near-instantaneous financial logging. By leveraging deep Android integration (Widgets, Quick Settings, and Local Sensors), the app eliminates the need for navigation.

### Key Pillars:
*   **Calculadora-First UI:** The app launches directly into a numeric keypad. No dashboard, no loading—just input.
*   **Tactile Macro Widgets:** Home screen buttons that trigger specific, pre-set transactions (e.g., "Daily Coffee - $5.00") with zero app interaction.
*   **Context-Aware Intelligence:** Uses local GPS coordinates to predict categories (e.g., "You are at Carrefour, suggesting 'Groceries'") without ever sending location data to the cloud.
*   **Quick Settings Integration:** A custom Tile in the Android notification shade allows for "floating" entries over other apps.
*   **Privacy-Centric Architecture:** A strictly offline-first approach using SQLite (Room), ensuring user data never leaves the device.

## 3. Target Users

### The Privacy Purist
*   **Profile:** Users who avoid Open Finance and banking sync features due to data leak concerns.
*   **Need:** A digital tool that feels as private as a physical notebook but offers the analytical power of a database.

### The Friction-Averse Millennial
*   **Profile:** High mobile usage, low patience for complex UI.
*   **Need:** An app that matches the speed of a contactless payment. They want to log the expense before they even put their phone back in their pocket.

### The "Mental Math" Burnout
*   **Profile:** Someone who tries to track spending in their head but loses track of small "invisible" expenses (snacks, small transfers).
*   **Need:** A "Quick Glance" widget that shows only the remaining monthly budget, acting as a behavioral nudge rather than a complex accounting sheet.

## 4. Core Value Proposition

*   **Zero-Latency Logging:** From pocket to "Transaction Saved" in under 3 seconds.
*   **Android Power-User Features:** Utilization of Quick Settings Tiles and Interactive Widgets to bypass the app icon entirely.
*   **Contextual Shortcuts:** Intelligent local suggestions based on time and location to reduce typing by 80%.
*   **Sovereign Data:** 100% offline. No accounts, no passwords, no cloud leaks. Data is backed up via the user's personal encrypted Google Drive backup system.
*   **Visual Gratification:** Instant, local generation of "Tactile Pop" style charts to visualize spending trends without the complexity of a spreadsheet.