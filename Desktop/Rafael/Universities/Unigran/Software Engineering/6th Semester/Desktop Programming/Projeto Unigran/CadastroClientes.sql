import mysql.connector

# Create a connection to the database
try:
    # Establish the connection
    connection = mysql.connector.connect(
        host='rafaelgerloff',
        user='rafaelgerloff',
        password='rafaelrafael.,hot',
        database='cadastro_clientes',  # This assumes the database is already created
        charset='utf8mb4'  # Specify UTF-8 character set
    )

    cursor = connection.cursor()

    # Create database if it does not exist
    cursor.execute("""
        CREATE DATABASE IF NOT EXISTS cadastro_clientes 
        CHARACTER SET utf8mb4 
        COLLATE utf8mb4_unicode_ci;
    """)

    # Create table if it does not exist
    cursor.execute("""
        CREATE TABLE IF NOT EXISTS cliente (
            id INT AUTO_INCREMENT PRIMARY KEY,
            nome VARCHAR(100) CHARACTER SET utf8mb4 NOT NULL,
            idade INT NOT NULL,
            endereco VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
    """)

    # Commit the changes
    connection.commit()
    print("Database and table created successfully.")

    # Optional: Query data or perform other operations
    cursor.execute("SELECT * FROM cliente;")
    results = cursor.fetchall()
    print("Query results:", results)

except mysql.connector.Error as e:
    print(f"Error: {e}")
except Exception as ex:
    print(f"An unexpected error occurred: {ex}")
finally:
    if connection.is_connected():
        cursor.close()
        connection.close()
