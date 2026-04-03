# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

D&D 5e Encounter Calculator — a web app for game masters to calculate encounter difficulty based on PC party levels and enemy XP values. It has two modules:

- `app/backend/` — Java/Micronaut REST API (stateless calculation engine)
- `app/frontend/encounter-calculator/` — Angular 10 web app

## Commands

### Backend
```bash
cd app/backend
mvn clean install       # Build
mvn test                # All tests
mvn test -Dtest=EncounterEngineTest  # Single test class
```

### Frontend
```bash
cd app/frontend/encounter-calculator
npm start               # Dev server (ng serve)
npm run build           # Production build
npm test                # Unit tests (Karma/Jasmine)
npm run e2e             # E2E tests (Protractor)
npm run lint            # TSLint
```

## Architecture

### Backend
Micronaut 4.x on Netty, Java 21. No persistence — pure stateless calculation engine.

- **Controllers** (`controller/`) — HTTP endpoints; `EncounterController` handles the two main POST routes
- **Engines** (`engine/`) — Business logic: `EncounterEngine`, `EnemyEngine`, `PCThresholdEngine`
- **Models** (`model/`) — `PCParty`/`PC`, `EnemyParty`/`Enemy`, `Difficulty` enum, `MonsterType` enum
- **Utils** (`utils/`) — Shared utilities

API endpoints:
- `POST /encounter/pc-thresholds` — XP thresholds for a PC party
- `POST /encounter/enemy-xp` — Total XP for enemy party

Swagger UI auto-generated from controller annotations; accessible at `/swagger-ui` when running locally.

### Frontend
Angular 10 with Angular Material (purple-green theme). Component-based state (no NgRx). Reactive Forms used throughout.

Feature modules map to domain concepts:
- `pc-party/` — PC party input form
- `enemy-party/` — Enemy party input form
- `result-view/` — Calculation results (encounter XP + PC thresholds)
- `party-view/` — Shared party display component

The frontend calls the backend via Angular `HttpClient`. API base URL is configured in `src/environments/environment.ts`.

### Lombok
Backend uses Lombok heavily — `@Data`, `@Builder`, `@AllArgsConstructor`, etc. Ensure annotation processing is enabled in your IDE.
