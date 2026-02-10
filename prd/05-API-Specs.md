# 05-API-Specs.md

Note: As an **Offline-First** application using Room (SQLite), these specifications define the Internal Data Layer API. These endpoints represent the contract between the UI (Jetpack Compose) and the Repository/Local Source of Truth. This structure ensures future compatibility with a Cloud Sync (REST) module.

## Authentication & Security
- **Auth Type:** Biometric (Fingerprint/Face) or Device PIN.
- **Scope:** Required for viewing Stats and Settings; Bypassed for "Quick Entry" (Calculator screen).

### POST /local/auth/verify
- **Auth:** Device Biometrics
- **Response Example:**
```json
{
  "status": "authenticated",
  "token_type": "local_session",
  "expires_in": 300
}
```

---

## Core Resources: Transactions

### GET /transactions
- **Auth:** Required
- **Query Params:** `limit` (int), `offset` (int), `category_id` (uuid), `date_start` (iso8601), `date_end` (iso8601)
- **Response Example:**
```json
[
  {
    "id": "550e8400-e29b-41d4-a716-446655440000",
    "amount": 25.50,
    "currency": "BRL",
    "category": {
      "id": "cat_food_01",
      "icon": "🍔",
      "label": "Lanches"
    },
    "timestamp": "2023-10-27T14:30:00Z",
    "location": {
      "lat": -23.5505,
      "lng": -46.6333
    },
    "source": "manual_input"
  }
]
```

### POST /transactions
- **Auth:** Optional (Open for "Flash Entry")
- **Request Body:**
```json
{
  "amount": 15.00,
  "category_id": "cat_transport_02",
  "timestamp": "2023-10-27T15:00:00Z",
  "geo_tag": true
}
```
- **Response Example:**
```json
{
  "status": "success",
  "transaction_id": "882e...",
  "toast_message": "Lançado: R$ 15,00 em Transporte"
}
```

---

## Smart Resources: Categories & Geo-Context

### GET /categories/suggested
- **Auth:** None
- **Description:** Returns the top 4 categories based on current GPS coordinates and frequency of use.
- **Response Example:**
```json
{
  "suggestions": [
    { "id": "cat_market_05", "label": "Mercado", "icon": "🛒", "confidence": 0.95 },
    { "id": "cat_coffee_03", "label": "Café", "icon": "☕", "confidence": 0.40 }
  ]
}
```

### PUT /categories/{id}
- **Auth:** Required
- **Description:** Update category thresholds or "Quick-Launch" macro values.
- **Request Body:**
```json
{
  "macro_value": 5.00,
  "is_priority": true
}
```

---

## User Operations: Recurring & Automation

### GET /recurring-expenses
- **Auth:** Required
- **Response Example:**
```json
[
  {
    "id": "rec_001",
    "label": "Netflix",
    "amount": 55.90,
    "due_day": 10,
    "auto_post": true
  }
]
```

### POST /voice/process
- **Auth:** Required
- **Description:** Processes natural language string via offline STT (Speech-to-Text).
- **Request Body:** `{ "query": "Cinquenta reais no posto de gasolina" }`
- **Response Example:**
```json
{
  "intent": "CREATE_TRANSACTION",
  "extracted_data": {
    "amount": 50.00,
    "category_hint": "Combustível",
    "raw_text": "Cinquenta reais no posto de gasolina"
  }
}
```

---

## Data Management (Export/Backup)

### GET /system/export
- **Auth:** Required
- **Format:** `application/json` or `text/csv`
- **Description:** Triggers the Android Storage Access Framework to save all Room DB records.

### POST /system/import
- **Auth:** Required
- **Description:** Replaces local DB with external JSON/CSV file.
- **Request:** Multi-part form data (File).
- **Response:** `{ "records_imported": 450, "status": "success" }`