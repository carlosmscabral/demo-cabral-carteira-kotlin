### 1. The 3-Second Lightning Entry (Calculator-First)
1. **User Action:** Opens the app via icon or Quick Settings Tile.
2. **System Response:** Immediately presents the "Tactile Pop" numeric keypad (no loading screens).
3. **User Action:** Types the amount (e.g., `54.90`).
4. **System Response:** Highlights the most likely categories (e.g., "Grocery" pulses if GPS coordinates match a known supermarket).
5. **User Action:** Taps the "Grocery" icon (🛒).
6. **System Response:** Triggers a haptic "click" feedback, saves the entry to the Room database, and displays a 1-second success animation (Green Check).
7. **System Response:** Automatically closes the app or resets the keypad for a new entry (configurable).

- **Success State:** Transaction saved with timestamp and GPS metadata; UI resets.
- **Error State:** Invalid amount (e.g., zero); "Save" button remains disabled.

---

### 2. The One-Touch Macro (Home Screen Widget)
1. **User Action:** Taps a pre-configured "Macro Widget" on the Android Home Screen (e.g., "Daily Coffee - R$ 6.00").
2. **System Response:** Triggers a background Intent without opening the main app UI.
3. **System Response:** Fetches the pre-defined values (Amount: 6.00, Category: Snacks, Label: Coffee).
4. **System Response:** Records the transaction in the SQLite database using current local time.
5. **System Response:** Shows a "Small Snack" SnackBar or Toast at the bottom of the Home Screen: "Logged R$ 6.00 to Snacks. [Undo]".
6. **User Action:** (Optional) Taps "Undo" within 3 seconds to delete the entry.

- **Success State:** Entry added silently; user never leaves the Home Screen.
- **Error State:** Database locked/busy; system retries in background or sends a "Failed to sync" notification.

---

### 3. Hands-Free Voice Entry (Offline NLP)
1. **User Action:** Long-presses the app icon or taps the Mic icon on the main keypad.
2. **System Response:** Activates the Android Speech-to-Text engine (Offline Mode).
3. **User Action:** Says "Thirty-five reais on Pharmacy."
4. **System Response:** Parses the string: 
    - *Value:* 35.00
    - *Category/Label:* Pharmacy
5. **System Response:** Displays a preview card with the parsed data and a countdown progress bar (2 seconds).
6. **User Action:** (Optional) Taps "Edit" if the parser fails.
7. **System Response:** If no intervention occurs, the transaction is committed to the local DB.

- **Success State:** Speech correctly mapped to `Double` and `String` (Category); confirmation haptic.
- **Error State:** Speech not recognized; system vibrates and opens the manual keypad with the "Label" field focused.