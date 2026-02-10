# 03-Feature-Specs.md

## P0: Core Features (The "3-Second" Experience)

### 1. Calculator-First Entry Interface
**User Story:** As a friction-averse user, I want the app to open directly to a numeric keypad so I can record a transaction without navigating any menus.

**Priority:** P0 (Critical)

**Acceptance Criteria:**
- [ ] App launch time to "Ready-to-Type" state is < 500ms.
- [ ] Initial screen is a full-screen numeric keypad (not a standard system keyboard).
- [ ] Decimal point handling is automatic (e.g., typing `2-5-0-0` results in `25.00`).
- [ ] A horizontal scrollable list of the top 5 most used category icons (e.g., 🍔, 🚗) is visible above the keypad.
- [ ] Single tap on a category icon saves the transaction and auto-closes the app or resets the view.

**Validation Rules:**
- Amount must be greater than 0.
- Category selection is mandatory for a "Quick Save."
- Maximum transaction limit: 9,999,999.99.

### 2. Offline-First Storage (Room DB)
**User Story:** As a privacy purist, I want my data stored exclusively on my device so that my financial habits are never exposed to external servers.

**Priority:** P0 (Critical)

**Acceptance Criteria:**
- [ ] Use Room Persistence Library for all CRUD operations.
- [ ] No network permissions requested in `AndroidManifest.xml`.
- [ ] Application remains fully functional without an internet connection.
- [ ] Data persists through app updates and device restarts.

**Validation Rules:**
- Transaction timestamps must use UTC for storage and local time for display.
- Database schema must include versioning for future migrations.

### 3. Quick Settings Tile (Overlay Entry)
**User Story:** As a power user, I want to log a spend while looking at my banking app or delivery app without switching contexts.

**Priority:** P0 (Critical)

**Acceptance Criteria:**
- [ ] Implement a `TileService` that appears in the Android Quick Settings shade.
- [ ] Clicking the tile opens a "Floating Window" (Dialog-style) over the current active app.
- [ ] The floating window contains a simplified version of the Calculator-First UI.
- [ ] Saving from the tile closes the overlay immediately.

**Validation Rules:**
- Overlay must not block the system "Back" or "Home" gestures.
- Transaction must sync to the main Room database instantly.

---

## P1: Friction Reducers & Automation

### 4. Smart Geofencing (Local Context)
**User Story:** As a frequent shopper, I want the app to predict my category based on my location so I don't have to select it manually.

**Priority:** P1 (High Value)

**Acceptance Criteria:**
- [ ] Capture GPS coordinates (latitude/longitude) at the moment of "Save."
- [ ] Store location-to-category mapping locally.
- [ ] If user is within 50 meters of a previous transaction location, highlight the previously used category (visual "pulsing" effect).
- [ ] Location data must never be transmitted off-device.

**Validation Rules:**
- Minimum accuracy threshold of 20m required to trigger "Smart Suggestion."
- Location permission requested only when the feature is toggled on.

### 5. Macro Widgets (One-Touch Launch)
**User Story:** As a routine-driven user, I want to tap a single icon on my home screen to log recurring small spends like "Coffee."

**Priority:** P1 (High Value)

**Acceptance Criteria:**
- [ ] Support for Android Home Screen App Widgets.
- [ ] Users can create "Macro Widgets" with a pre-set Amount, Category, and Label (e.g., "R$ 5.00 - Café").
- [ ] Tapping the widget logs the entry instantly without opening the full app UI.
- [ ] Visual feedback (Toast or Snackbar) confirms the entry.

**Validation Rules:**
- Macros must be editable via the main app settings.
- Duplicate tap protection: Prevent identical logs within 2 seconds.

### 6. Recurring "Automatic" Logs
**User Story:** As a busy individual, I want the app to handle my fixed bills automatically so I only have to focus on variable spending.

**Priority:** P1 (High Value)

**Acceptance Criteria:**
- [ ] Interface to define "Fixed Expenses" (Monthly/Weekly).
- [ ] Background Worker (`WorkManager`) to trigger at 00:01 on the scheduled date.
- [ ] Option to notify the user when a recurring expense is logged.
- [ ] Support for "Installments" (e.g., 1 of 12).

**Validation Rules:**
- Start date cannot be in the past.
- Logic must handle "End of Month" edge cases (e.g., Feb 28th vs Jan 31st).

### 7. "Flash Voice" (Offline STT)
**User Story:** As a user on the go, I want to speak my expense so I can log it while walking or carrying bags.

**Priority:** P1 (High Value)

**Acceptance Criteria:**
- [ ] Integration with Android `SpeechRecognizer` (Offline mode).
- [ ] Natural Language Processing (Regex-based) to extract:
    - Amount (e.g., "Trinta e cinco reais")
    - Category/Description (e.g., "na padaria")
- [ ] UI feedback shows interpreted text before final save.

**Validation Rules:**
- Must identify numerical values in strings.
- Fail gracefully if voice input is not understood, reverting to manual entry.