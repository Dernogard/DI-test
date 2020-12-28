package com.example.daggertest.di

import dagger.Module

@Module(subcomponents = [UserComponent::class, MainComponent::class])
class AppSubcomponent