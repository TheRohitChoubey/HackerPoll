import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HackerDetailsComponent } from './hacker-details.component';

describe('HackerDetailsComponent', () => {
  let component: HackerDetailsComponent;
  let fixture: ComponentFixture<HackerDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HackerDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HackerDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
