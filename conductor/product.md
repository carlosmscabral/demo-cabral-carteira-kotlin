# Carteira do Cabral (FlashGastos) - Product Guide

## 1. Project Overview
**Carteira do Cabral** is an "Input-First" Android application designed for near-instantaneous financial logging. Addressing the "Friction Gap" in personal finance, it adheres strictly to a **"3-Second Rule"**: from pocket to "Transaction Saved" in under 3 seconds. By leveraging native Android integrations (Widgets, Quick Settings, Local Sensors) and an offline-first architecture, it eliminates the need for navigation, loading screens, or cloud accounts.

## 2. Target Users
*   **The Privacy Purist:** Users who demand 100% data sovereignty and refuse to link bank accounts or sync data to the cloud. They want the privacy of a physical notebook with the power of a digital database.
*   **The Friction-Averse Millennial:** Mobile-first users with zero patience for complex UI. They require an app that matches the speed of a contactless payment—log and go.
*   **The "Mental Math" Burnout:** Individuals who lose track of small, "invisible" daily expenses (snacks, fees) and need simple behavioral nudges (like a "Remaining Budget" counter) rather than complex accounting dashboards.

## 3. High-Level Goals
*   **Extreme Friction Reduction:** Enable transaction logging in under 3 seconds via a "Calculator-First" UI and "One-Tap" categorization.
*   **Data Sovereignty:** Provide a strictly **Offline-First** architecture (Room DB) with no internet permissions, ensuring user data never leaves the device.
*   **Native Android Integration:** Utilize OS-level features like Home Screen Macro Widgets and Quick Settings Tiles to allow logging without fully opening the app.
*   **Contextual Intelligence:** Use local processing (Geofencing) to predict transaction categories based on location, reducing input time.
*   **Visual Immediacy:** Provide instant feedback on financial health via a simple "Budget Glance" and tactile haptic feedback, avoiding complex reports during data entry.

## 4. Initial Concept
(Derived from MVP Checklist)
*   **Calculator-First UI:** Main Activity opens directly to numeric input.
*   **One-Tap Categorization:** Grid of emoji buttons immediately saves the transaction.
*   **Room Implementation:** Save `Transaction` entity with `timestamp`, `amount`, and `category`.
*   **Budget Glance:** Simple "Remaining Budget" calculation displayed on the main input screen.
*   **Haptic Feedback:** Tactile vibrations on keypad and save confirmation.
