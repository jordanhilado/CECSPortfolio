import math
C = 299792458
seconds_per_day = 86400
distance_to_PA = 7.4740 * 10**16

user_velocity = float(input('Enter space ship velocity as a fraction of the speed of light:'))
print('Traveling to Proxima Alpha...')
v = C * user_velocity
dilation = math.sqrt(1 - ((v**2)/(C**2)))
earth_time_seconds = distance_to_PA / v
passenger_time_seconds = earth_time_seconds * dilation

earth_days = earth_time_seconds / seconds_per_day
earth_years = earth_days // 365
earth_d = earth_days % 365

passenger_d = passenger_time_seconds / seconds_per_day
passenger_years = passenger_d // 365
passenger_days = passenger_d % 365

print('An observer on Earth ages', int(earth_years), 'years, ', int(earth_d), 'days during the trip.')
print('A passenger on the ship ages', int(passenger_years), 'years, ', int(passenger_days), 'days during the trip.')