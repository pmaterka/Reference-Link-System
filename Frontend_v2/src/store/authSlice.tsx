import {createSlice} from '@reduxjs/toolkit'

export interface AuthSlice {
    userId: string | null;
    token: string | null;
}

const initialState:AuthSlice = {
    userId: 'u123456',
    token:  'abc'
}

const authSlice = createSlice({
    name: 'auth',
    initialState,
    reducers: {
        login(state:AuthSlice, action) {
            state.userId = action.payload.userId;
            state.token = action.payload.token;
        },
        logout(state:AuthSlice) {
            state.userId = null;
            state.token = null;
        }
    }
});

export default authSlice.reducer;

export const authActions = authSlice.actions;