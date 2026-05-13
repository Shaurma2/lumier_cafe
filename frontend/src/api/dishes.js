import axios from 'axios';

const API_URL = 'http://localhost:8080/api/dishes';

export const getDishes = () => axios.get(API_URL);
export const createDish = (dish) => axios.post(API_URL, dish);
export const deleteDish = (id) => axios.delete(`${API_URL}/${id}`);