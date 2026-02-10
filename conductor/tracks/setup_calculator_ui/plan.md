# Implementation Plan - Setup & Calculator-First UI

## Phase 1: Project Scaffolding & Dependencies
- [~] Task: Add project dependencies (Room, Hilt, Navigation) to `libs.versions.toml` and `app/build.gradle.kts`.
- [ ] Task: Configure Hilt (Application class, AndroidManifest, `@AndroidEntryPoint`).
- [ ] Task: Conductor - User Manual Verification 'Phase 1: Project Scaffolding & Dependencies' (Protocol in workflow.md)

## Phase 2: Data Layer (Room)
- [ ] Task: Create `Category` and `Transaction` Entities.
- [ ] Task: Create `CategoryDao` and `TransactionDao`.
- [ ] Task: Create `AppDatabase` and configured Room.
- [ ] Task: Implement `LocalRepository` to manage data access.
- [ ] Task: Create a Hilt Module (`DatabaseModule`) to provide DAO and Repository instances.
- [ ] Task: Conductor - User Manual Verification 'Phase 2: Data Layer (Room)' (Protocol in workflow.md)

## Phase 3: Domain Layer & Pre-population
- [ ] Task: Create a `PrepopulateCallback` for Room to seed default categories (Food, Transport, etc.) on first run.
- [ ] Task: Create `SaveTransactionUseCase`.
- [ ] Task: Conductor - User Manual Verification 'Phase 3: Domain Layer & Pre-population' (Protocol in workflow.md)

## Phase 4: UI Foundation (Tactile Pop)
- [ ] Task: Define Color Palette in `ui/theme/Color.kt` (Indigo, Pink, Emerald).
- [ ] Task: Define Type Styles in `ui/theme/Type.kt`.
- [ ] Task: Create `TactileButton` composable (Common button style with animation).
- [ ] Task: Conductor - User Manual Verification 'Phase 4: UI Foundation (Tactile Pop)' (Protocol in workflow.md)

## Phase 5: Calculator Components
- [ ] Task: Create `AmountDisplay` composable (Large text, auto-formatting logic).
- [ ] Task: Create `NumericKeypad` composable (Grid layout).
- [ ] Task: Create `CategorySelector` composable (Horizontal/Grid list).
- [ ] Task: Conductor - User Manual Verification 'Phase 5: Calculator Components' (Protocol in workflow.md)

## Phase 6: Feature Assembly & Integration
- [ ] Task: Create `CalculatorViewModel` (Handle state: input string, selected category, saving).
- [ ] Task: Implement `CalculatorScreen` (Assemble components, observe ViewModel).
- [ ] Task: Update `MainActivity` to host the `CalculatorScreen`.
- [ ] Task: Verify functionality (Type -> Select Category -> Save -> Check DB/Log).
- [ ] Task: Conductor - User Manual Verification 'Phase 6: Feature Assembly & Integration' (Protocol in workflow.md)
