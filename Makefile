.PHONY: up down logs ps reset

up:
	@echo "Starting IoT platform services..."
	docker-compose up -d

down:
	@echo "Stopping and removing services..."
	docker-compose down

logs:
	docker-compose logs -f

ps:
	docker-compose ps

reset:
	@echo "Resetting platform..."
	docker-compose down -v
	rm -rf data/postgres data/grafana
	docker-compose up -d
