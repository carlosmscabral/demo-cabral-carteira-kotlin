# 06-UI-Specs.md

## 1. Design Tokens

The "Tactile Pop" theme prioritizes high contrast, clear boundaries, and immediate visual feedback.

| Token | Variable Name | Hex Code | Usage |
| :--- | :--- | :--- | :--- |
| **Primary** | `--color-indigo-500` | `#6366F1` | Primary Actions, Keypad Digits |
| **Background** | `--color-slate-50` | `#F8FAFC` | App Background, Screen Base |
| **Accent** | `--color-pink-500` | `#EC4899` | Highlights, Micro-interactions |
| **Success** | `--color-emerald-500` | `#10B981` | Positive Balances, Confirmations |
| **Surface** | `--color-slate-100` | `#F1F5F9` | Secondary Buttons, Cards, Keypad Base |
| **Text-Main** | `--color-slate-900` | `#0F172A` | Primary Typography |
| **Text-Muted** | `--color-slate-500` | `#64748B` | Labels and Secondary Info |

## 2. Typography (System Default: Roboto/Inter)

| Role | Weight | Size | Usage |
| :--- | :--- | :--- | :--- |
| **Display** | Bold (700) | 48px | Active input value (The "Big Number") |
| **H1** | Bold (700) | 24px | Screen titles, Section headers |
| **H2** | Semi-Bold (600) | 18px | Widget titles, Card headers |
| **Body** | Regular (400) | 16px | Category labels, Descriptions |
| **Caption** | Medium (500) | 12px | Secondary metadata, Micro-labels |

## 3. Component States

### Buttons (Keypad & Categories)
- **Default:** Background: `--surface`, Elevation: 2dp, Border-radius: 12px.
- **Pressed (Tactile Pop):** Scale down to 95%, Background: `--primary`, Text: `#FFFFFF`.
- **Focused:** 2px border using `--accent`.

### Inputs (Numeric Display)
- **Empty:** Color: `--text-muted`, Value: "0,00".
- **Active:** Color: `--text-main`, Blink cursor using `--accent`.
- **Error:** Text color transitions to `--accent` with a horizontal shake animation.

### Category Chips
- **Idle:** Grey icon on `--surface`.
- **Active (Selected):** White icon on `--primary` with a subtle glow effect (Shadow: 0 4px 14px 0 `--color-indigo-500`).

## 4. ASCII Wireframe: Main Entry Screen (Calculator-First)

```text
_________________________________________
| [⚙️ Settings]          [Rest: R$ 450] | (Top Bar)
|_______________________________________|
|                                       |
|          R$ 25,00                     | (Display - Display Size)
|_______________________________________|
|                                       |
|   [ 1 ]       [ 2 ]       [ 3 ]       | (Keypad Area)
|                                       |
|   [ 4 ]       [ 5 ]       [ 6 ]       |
|                                       |
|   [ 7 ]       [ 8 ]       [ 9 ]       |
|                                       |
|   [ . ]       [ 0 ]       [ ⌫ ]       |
|_______________________________________|
| QUICK CATEGORIES (Horizontal Scroll)  |
|                                       |
|  (🍔)       (🚗)       (🏠)      (🛒)  | (Icons: 32dp)
|  Food      Transp     Home      Shop  |
|_______________________________________|
|                                       |
|      [ 🎙️ HOLD TO SPEAK COMMAND ]      | (Bottom Bar)
|_______________________________________|
```